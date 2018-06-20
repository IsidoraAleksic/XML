import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SettingsService } from '../../services/settings.service';
import { FormGroup, FormBuilder, Validators, ValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  form: FormGroup;

  advanced: boolean;
  search: any = {
    type: 1,
    category: 1
  };

  @Output() basicSearch = new EventEmitter<any>();
  @Output() advancedSearch = new EventEmitter<any>();

  constructor(
    private fb: FormBuilder,
    public settings: SettingsService
  ) { }

  ngOnInit() {
    var pingpong = false;

    var startDateValidator: ValidatorFn = (c: AbstractControl) => {
      if (!c.value)
        return null;

      let isValid = true;
      let errors = {};

      if (this.form.value.endDate && c.value >= this.form.value.endDate) {
        isValid = false;
        errors['afterEnd'] = true;
      }

      if (c.value <= new Date()) {
        isValid = false;
        errors['beforeToday'] = true;
      }

      if (!pingpong && this.form.value.endDate) {
        pingpong = true;
        var old = this.form.controls['endDate'].value;
        this.form.controls['endDate'].setValue(null);
        this.form.controls['endDate'].setValue(old);
        this.form.controls['endDate'].markAsDirty({onlySelf: true});
      } else {
        pingpong = false;
      }

      return isValid ? null : errors;
    };

    var endDateValidator: ValidatorFn = (c: AbstractControl) => {
      if (!c.value)
        return null;

      let isValid = true;
      let errors = {};
      if (this.form.value.startDate && c.value <= this.form.value.startDate) {
        isValid = false;
        errors['beforeStart'] = true;
      }

      if (c.value <= new Date()) {
        isValid = false;
        errors['beforeToday'] = true;
      }

      if (!pingpong && this.form.value.startDate) {
        pingpong = true;
        var old = this.form.controls['startDate'].value;
        this.form.controls['startDate'].setValue(null);
        this.form.controls['startDate'].setValue(old);
      } else {
        pingpong = false;
      }

      return isValid ? null : errors;
    };

    this.form = this.fb.group({
      place: ['', [Validators.required, Validators.minLength(2)]],
      people: ['', [Validators.required, Validators.min(1)]],
      startDate: ['', [Validators.required, startDateValidator]],
      endDate: ['', [Validators.required, endDateValidator]]
    })
  }

  onSearch() {
    if(this.form.invalid) {
      Object.keys(this.form.controls).forEach(field => { // {1}
        const control = this.form.get(field);            // {2}
        control.markAsTouched({ onlySelf: true });       // {3}
      });      
      return;    
    }

    this.search.place = this.form.value.place;
    this.search.people = this.form.value.people;
    this.search.startDate = this.form.value.startDate;
    this.search.endDate = this.form.value.endDate;

    if (this.advanced) {
      this.advancedSearch.emit(this.search);
    }
    else {
      this.basicSearch.emit(this.search);
    }


  }

}
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { BackgroundStyleService } from '../../services/background-style.service';
import { ReservationService } from '../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.css']
})
export class ConversationComponent implements OnInit {

  reservation: any;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public bg: BackgroundStyleService,
    public auth: AuthService,
    private reservationService: ReservationService
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.reservationService.getOne(params['id']).subscribe(_=>{
        console.log(_);
        this.reservation = _;
      }, err=>{
        this.router.navigateByUrl("");
      })
    })    
  }

}

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { BackgroundStyleService } from '../../services/background-style.service';
import { ReservationService } from '../../services/reservation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from '../../services/message.service';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.css']
})
export class ConversationComponent implements OnInit {

  // reservation: any;
  input: string;
  messages: any[] = [];
  id: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    public bg: BackgroundStyleService,
    public auth: AuthService,
    private reservationService: ReservationService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      this.messageService.getAll(this.id).subscribe(x => {
        this.messages = x;
      })
      // this.reservationService.getOne(params['id']).subscribe(_=>{
      // console.log(_);
      // this.reservation = _;
      // }, err=>{
      // this.router.navigateByUrl("");
      // })
    })
  }

  onSend() {
    var message = {
      reservation: {
        id: this.id
      },
      message: this.input,
      agent: false
    }
    this.input = "";
    this.messageService.send(message).subscribe(x => {
      this.messages.push(message);
    })

  }

}

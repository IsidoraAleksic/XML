import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { V2IndexComponent } from './components/v2-index/v2-index.component';
import { ConversationComponent } from './components/conversation/conversation.component';

const routes: Routes = [
  { path: "", component: V2IndexComponent },
  { path: "messages/:id", component: ConversationComponent },
  { path: "register", component: RegisterComponent },
  { path: "profile", component: ProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

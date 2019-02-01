import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { NgForm } from '@angular/forms';
import { UserDataProvider } from '../../providers/user-data';
import { SignupPage } from '../signup/signup';
import { TabsPage } from '../tabs/tabs';



/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  login: any = { username: '', password: '' };
  submitted = false;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public userData: UserDataProvider) {
  }

  onLogin(form: NgForm) {
    this.submitted = true;

    if (form.valid) {
      this.userData.login(this.login.username, this.login.password);
      this.navCtrl.push(TabsPage);
    }
  }

  onSignUp() {
    this.navCtrl.push(SignupPage);
  }

}

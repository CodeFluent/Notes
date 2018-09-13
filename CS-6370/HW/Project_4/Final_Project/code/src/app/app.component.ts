/**
 * From the ionic-conference-app setup.
 *
 */

import { Component, ViewChild } from '@angular/core';
import { Nav, Platform, AlertController, MenuController } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { TabsPage } from '../pages/tabs/tabs';
import { HomePage } from '../pages/home/home';
import { FeedPage } from '../pages/feed/feed';
import { SubscribePage } from '../pages/subscribe/subscribe';

import { LoginPage } from '../pages/login/login';
import { SignupPage } from '../pages/signup/signup';


import { UserDataProvider } from '../providers/user-data';

export interface PageInterface {
  title: string;
  name: string;
  icon: string;
  component?: any;
  index?: number;
  tabName?: string;
  tabComponent?: any;
}

@Component({
  templateUrl: 'app.html'
})
export class CampusMap {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = TabsPage;

  allPages: PageInterface[] = [
    { title: 'Main Map', name: 'Mainmap', component: TabsPage, tabComponent: HomePage, index: 0, icon: 'map' },
    { title: 'Feeds', name: 'FeedPage', component: TabsPage, tabComponent: FeedPage, index: 1, icon: 'paper' },
    { title: 'Subscriptions', name: 'SubscribePage', component: TabsPage, tabComponent: SubscribePage, index: 2, icon: 'settings' }
  ];
  loggedInPages: PageInterface[] = [
    { title: 'Logout', name: 'LogoutPage', icon: 'log-out' }
  ];
  loggedOutPages: PageInterface[] = [
    { title: 'Login', name: 'LoginPage', component: LoginPage, icon: 'log-in' },
    { title: 'Signup', name: 'SignupPage', component: SignupPage, icon: 'person-add' }
  ];

  constructor(
    public menu: MenuController,
    public platform: Platform,
    public statusBar: StatusBar,
    public splashScreen: SplashScreen,
    public userData: UserDataProvider,
    private alertCtrl: AlertController) {

    this.platformReady();

    // load feed data

    this.enableMenu();

  }

  alertLogout() {
    let alert = this.alertCtrl.create({
      title: 'Do you wish to logout?',
      buttons: [
        {
          text: 'Dismiss',
          role: 'cancel'
        },
        {
          text: 'Logout',
          handler: () => {
            this.userData.logout();
            this.enableMenu();
          }
        }
      ]
    });
    alert.present();
  }

  enableMenu() {
    if (this.userData.IS_LOGGED_IN === true) {
      console.log("menu login");
      this.menu.enable(true, 'loggedInMenu');
    } else {
      console.log("menu logout");
      this.menu.enable(true, 'loggedOutMenu');
    }
  }

  openPage(page: PageInterface) {
    let params: {};

    if (page.index) {
      params = { tabIndex: page.index };
    }

    if (this.nav.getActiveChildNavs().length && page.index != undefined) {
      this.nav.getActiveChildNav()[0].select(page.index);
    } else {
      this.nav.setRoot(page.name, params).catch((err: any) => {
        console.log("Error with settings nav...", err);
      });
    }

    if (page.name === "LogoutPage") {
      this.alertLogout();
    }

  }

  platformReady() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}


import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { HomePage } from '../home/home';
import { SubscribePage } from '../subscribe/subscribe';
import { FeedPage } from '../feed/feed';

@IonicPage()
@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html',
})
export class TabsPage {

  tab1Root: any = FeedPage;
  tab2Root: any = HomePage;
  tab3Root: any = SubscribePage;

  tab1Title = "Feed";
  tab2Title = "Map";
  tab3Title = "Subscribe";

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {

  }

}

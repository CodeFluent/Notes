import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { FeedDataProvider } from '../../providers/feed-data';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HomePage } from '../home/home';

const env = "http://localhost:5984/";

@IonicPage()
@Component({
  selector: 'page-feed',
  templateUrl: 'feed.html',
})
export class FeedPage {

  datasub: any;
  feeditems: any;

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public feedData: FeedDataProvider,
    public http: HttpClient
  ) {
  }

  ionViewDidLoad() {

    let url = env + "feed/_design/feed/_view/All%20Feed%20Items";

    this.http.get(url).map(res => res)
      .subscribe(
        data => {
          this.datasub = data;
          this.feeditems = this.datasub.rows;
          console.log(this.feeditems);
        },
        err => console.log(err),
    );
  }

  goToMarker(geopoint: any, title: string) {
    console.log(geopoint);
    this.navCtrl.push(HomePage, { geopoint: geopoint, title: title });
  }

}

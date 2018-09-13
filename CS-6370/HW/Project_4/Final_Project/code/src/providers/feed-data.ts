import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

const env = "http://localhost:5984/";
// make sure in local.ini has cors enabled and allows localhost as origin

@Injectable()
export class FeedDataProvider {

  feeditems: any;

  constructor(public http: HttpClient) {
  }

  getFeedItems() {
    let url = env + "feed/_design/feed/_view/foo";

    return this.http.get(url).map(res => res)
      .subscribe(
        data => {
          this.feeditems = data;
        },
        err => console.log(err),
    );
  }
}

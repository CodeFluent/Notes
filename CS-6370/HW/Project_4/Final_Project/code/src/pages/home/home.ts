import { Component, ViewChild, ElementRef } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import L from 'leaflet';
import { unescapeIdentifier } from '@angular/compiler';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  @ViewChild('map') mapContainer: ElementRef;
  map: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {

  }

  ionViewDidEnter() {
    this.loadMap();
  }

  loadMap() {

    this.map = L.map('map').setView([33.75268, -84.38540], 17);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.map);

    let geo = this.navParams.get('geopoint');
    let title = this.navParams.get('title');

    if (geo && geo !== undefined) {
      if (title === undefined || title === '') {
        title = "Location";
      }
      L.marker([geo[0], geo[1]]).addTo(this.map)
        .bindPopup('<p>' + title + '</p>')
        .openPopup();
    }


  }

  ionViewDidLeave() {
    this.map.remove();
  }
}
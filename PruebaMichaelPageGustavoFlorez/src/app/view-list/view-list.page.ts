import { Component, OnInit } from '@angular/core';
import {AppService } from '../Servicios/app.service';
import { userTO } from '../userTO/userTO';

@Component({
  selector: 'app-view-list',
  templateUrl: './view-list.page.html',
  styleUrls: ['./view-list.page.scss'],
})
export class ViewListPage implements OnInit {

  usuarios:Array<userTO> = [];
  constructor(private appService:AppService) { }

  ngOnInit() {
    this.obtenerListadoFireBase()
  }

  obtenerListadoFireBase(){
    this.appService.obtenerJsonFireBase()
                          .subscribe(
                            responseJS =>{
                              this.usuarios = responseJS
                            });
  }
}

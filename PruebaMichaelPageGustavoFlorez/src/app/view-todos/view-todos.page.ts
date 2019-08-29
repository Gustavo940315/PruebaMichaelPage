import { Component, OnInit } from '@angular/core';
import { userTO } from  '../userTO/userTO';
import { AppService } from '../Servicios/app.service';
import { AlertController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-todos',
  templateUrl: './view-todos.page.html',
  styleUrls: ['./view-todos.page.scss'],
})
export class ViewTodosPage implements OnInit {

  usuarios:Array<userTO> = [];

  constructor(private ServicioConsultarUsuario: AppService) { }

  ngOnInit() {
    this.ServicioViewUsuario()
  }

  ServicioViewUsuario(){
    this.ServicioConsultarUsuario.getUsuario().subscribe(
      responseJS =>{
        this.usuarios = responseJS.body
      });   
  }
}

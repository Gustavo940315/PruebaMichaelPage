import { Component, OnInit } from '@angular/core';
import { userTO } from  '../userTO/userTO';
import {AppService } from '../Servicios/app.service';
import { AlertController } from '@ionic/angular';
@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.page.html',
  styleUrls: ['./edit-item.page.scss'],
})
export class EditItemPage implements OnInit {

  usuarios:userTO = new userTO();
  mensaje: string ="";

  constructor(private appService:AppService,
              public alertController: AlertController) { }

  ngOnInit() {
  }

  ServicioEditarRegistro(){
    this.appService.editarPerfilServicio(this.usuarios)
                    .subscribe(
                      responseJS =>{
                         if(responseJS.body== 'ok'){
                          this.presentAlert("registro actualizado");
                         }else{
                          this.presentAlert(responseJS.body);
                         }
                      });
  }

  async presentAlert(mensaje:string) {
    const alert = await this.alertController.create({
      header: 'Notificacion',
      subHeader: 'Respuesta Api Rest',
      message: mensaje,
      buttons: ['OK']
    });

    await alert.present();
  }

}

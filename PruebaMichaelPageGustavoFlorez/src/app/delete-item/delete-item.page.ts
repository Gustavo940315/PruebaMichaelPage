import { Component, OnInit } from '@angular/core';
import { userTO } from  '../userTO/userTO';
import {AppService } from '../Servicios/app.service';
import { AlertController } from '@ionic/angular';
@Component({
  selector: 'app-delete-item',
  templateUrl: './delete-item.page.html',
  styleUrls: ['./delete-item.page.scss'],
})
export class DeleteItemPage implements OnInit {

  usuarios:userTO = new userTO();
  mensaje: string ="";

  constructor(private appService:AppService,
              public alertController: AlertController) { }

  ngOnInit() {
  }

  ServicioEliminarRegistro(){
    this.appService.eliminarUsuario(this.usuarios.id)
                    .subscribe(
                      responseJS =>{
                         if(responseJS.body== 'ok'){
                          this.presentAlert("registro Eliminado");
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

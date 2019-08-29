import { Component, OnInit } from '@angular/core';
import { userTO } from  '../userTO/userTO';
import { AppService } from '../Servicios/app.service';
import { AlertController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-item',
  templateUrl: './create-item.page.html',
  styleUrls: ['./create-item.page.scss'],
})
export class CreateItemPage implements OnInit {

  usuarios:userTO = new userTO();
  mensaje: string ="";

  constructor(private servicioInsertarUser : AppService,
              public alertController: AlertController,
              private router: Router) { }

  ngOnInit() {
  }

  ServicioCrearRegistro(){

    this.servicioInsertarUser.servicioRegistro(this.usuarios).subscribe(responseJS =>{if(responseJS.body == 'ok'){
      this.mensaje = 'Se registro exitosamente el usuario.';
      this.mostrarMensaje(this.mensaje);
      this.router.navigate(["/home"]);
    }else{
      this.mensaje = 'No se registro el usuario.'
      this.mostrarMensaje(this.mensaje);
      
        }
    } );
  }

  async mostrarMensaje(mnj:string) {  
    const alert = await this.alertController.create({
      message: mnj,
      buttons: ['OK']
    });

    await alert.present();
  }
}

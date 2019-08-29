import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppSettings } from '../constantes';
import { userTO } from  '../userTO/userTO';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

const urlApiRest=AppSettings.API_HOST;

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http:HttpClient) { }

  editarPerfilServicio( usuarios: userTO){
    return this.http.put<any>(urlApiRest+"actualizar",usuarios,httpOptions);
  }

  obtenerJsonFireBase():Observable<any>{
    return this.http.get("https://jsonplaceholder.typicode.com/todos",httpOptions);
  }

  servicioRegistro(user:userTO){
    return this.http.post<any>(urlApiRest+"registrar",user,httpOptions);
  }

  getUsuario():Observable<any>{
    return this.http.get(urlApiRest+"listar",httpOptions);
  }

  eliminarUsuario(numeroIdetificacionUsuario: Number):Observable<any>{
    return this.http.delete<any>(urlApiRest+"eliminar"+"?id="+numeroIdetificacionUsuario,httpOptions);
  }
}

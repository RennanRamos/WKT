import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estados } from './tipo/estados';
import { IMC } from './tipo/imc';
import { Obesidade } from './tipo/obesidade';
import { TipoSangue } from './tipo/tipoSangue';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http: HttpClient) { }

  getStates(): Observable<Estados[]> {
    return this.http.get<Estados[]>('http://localhost:8080/api/Donators/states');
  }

  getImc(): Observable<IMC[]> {
    return this.http.get<IMC[]>('http://localhost:8080/api/Donators/imc');
  }

  getObesity(): Observable<Obesidade[]> {
    return this.http.get<Obesidade[]>('http://localhost:8080/api/Donators/obesity');
  }

  getBloodType(): Observable<TipoSangue[]> {
    return this.http.get<TipoSangue[]>('http://localhost:8080/api/Donators/bloodType');
  }

  getReceptors(): Observable<TipoSangue[]>  {
    return this.http.get<TipoSangue[]>('http://localhost:8080/api/Donators/receptors');
  }
}

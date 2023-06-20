import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { IMC } from '../tipo/imc';
import { Base } from '../tipo/base';

@Component({
  selector: 'app-page2',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.scss'],
})
export class Page2Component implements OnInit {
  barChartOptions = {
    responsive: true,
  };
  barChartLabels: string[] = [];
  barChartType: ChartType = 'bar';
  barChartData: any[] = [
    {
      data: [],
      label: 'Valor',
      backgroundColor: 'rgba(0, 123, 255, 0.5)'
    },
  ];

  constructor(private ApiService: ApiService) {}

  ngOnInit() {
    this.getImc();
  }

  getImc() {
    this.ApiService.getImc().subscribe(
      (response: IMC[]) => {
        const imcData =  this.tratarDados(response);
        this.barChartLabels = imcData.map((data) => data.valor);
        this.barChartData[0].data = imcData.map((data) => data.chave);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  tratarDados(response: IMC[]){
    var listaRetorno: Base[] = [];

    let item1 = {} as Base;
    item1.valor = '0 a 10';
    item1.chave = 0;

    let item2 = {} as Base;
    item2.valor = '11 a 20';
    item2.chave = 0;

    listaRetorno.push(item1);
    listaRetorno.push(item2);

    response.forEach(element => {
      let item = {} as Base;

      var idade = element.idade - 9;

      item.valor = (idade.toString() + ' a ' + element.idade.toString());
      item.chave = element.imc;

      listaRetorno.push(item)
    });

    let item3 = {} as Base;
    item3.valor = '99 a 100';
    item3.chave = 0;
    listaRetorno.push(item3);

    return listaRetorno;
  }

}

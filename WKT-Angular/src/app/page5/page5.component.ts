import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { TipoSangue } from '../tipo/tipoSangue';
import { Base } from '../tipo/base';

@Component({
  selector: 'app-page5',
  templateUrl: './page5.component.html',
  styleUrls: ['./page5.component.scss'],
})
export class Page5Component implements OnInit {
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
    this.getReceptors();
  }

  getReceptors() {
    this.ApiService.getReceptors().subscribe(
      (response: TipoSangue[]) => {
        const tipoSangueData =  response;
        this.barChartLabels = tipoSangueData.map((data) => data.bloodType);
        this.barChartData[0].data = tipoSangueData.map((data) => data.quant);
      },
      (error) => {
        console.log(error);
      }
    );
  }

}

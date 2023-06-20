import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { TipoSangue } from '../tipo/tipoSangue';

@Component({
  selector: 'app-page4',
  templateUrl: './page4.component.html',
  styleUrls: ['./page4.component.scss'],
})
export class Page4Component implements OnInit {
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
    this.getBloodType();
  }

  getBloodType() {
    this.ApiService.getBloodType().subscribe(
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

import { Obesidade } from '../tipo/obesidade';
import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';

@Component({
  selector: 'app-page3',
  templateUrl: './page3.component.html',
  styleUrls: ['./page3.component.scss'],
})
export class Page3Component implements OnInit {
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
    this.getObesity();
  }

  getObesity() {
    this.ApiService.getObesity().subscribe(
      (response: Obesidade[]) => {
        const obesidadeData =  response;
        this.barChartLabels = obesidadeData.map((data) => data.genero);
        this.barChartData[0].data = obesidadeData.map((data) => data.por);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

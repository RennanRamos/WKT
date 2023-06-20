import { ApiService } from './../api.service';
import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { Estados } from '../tipo/estados';


@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.scss'],
})
export class Page1Component implements OnInit {
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
    this.getStates();
  }

  getStates() {
    this.ApiService.getStates().subscribe(
      (response: Estados[]) => {
        const estadosData = response;
        this.barChartLabels = estadosData.map((data) => data.estado);
        this.barChartData[0].data = estadosData.map((data) => data.quant);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

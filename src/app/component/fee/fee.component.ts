import { Component, OnInit } from '@angular/core';
import { FeeModel } from 'src/app/model/fee.model';
import { FeeService } from 'src/app/service/fee.service';

@Component({
  selector: 'app-fee',
  templateUrl: './fee.component.html',
  styleUrls: ['./fee.component.less']
})
export class FeeComponent implements OnInit {

  fees: FeeModel[];

  constructor(private feeService: FeeService) { }

  ngOnInit(): void {
    this.feeService.getFees().subscribe({
      next: (data) => {
        this.fees = data;
        this.feeService.fee$.next(this.fees);
      },
      error: (e) => {
        console.log(e);
      }
    })

    this.feeService.fee$.subscribe(data => {
      this.fees = data;
    })
  }

  markPaid(id: number) {
    console.log(id);
    this.feeService.updateFee(this.fees[id]).subscribe({
      next: (data) => {
        let pName = this.fees[id].patronName;
        this.fees[id] = data;
        this.fees[id].patronName = pName;
        this.feeService.fee$.next(this.fees);
      }
    });
  }

}

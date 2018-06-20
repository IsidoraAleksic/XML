import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'beforeToday'
})
export class BeforeTodayPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (args === false)
      return new Date(value) > new Date();
    return new Date(value) < new Date();
  }

}

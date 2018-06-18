import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'notIn',
  pure: false
})
export class NotInPipe implements PipeTransform {

  transform(value: any[], args?: any[]): any {
    if (args && value)
      value = value.filter(x=> args.indexOf(x) == -1);
    return value;
  }

}

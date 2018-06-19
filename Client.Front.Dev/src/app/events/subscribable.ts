import { Observable, PartialObserver, Subscription, Subscriber } from "rxjs";

export class Subscribable<T> {


    private subscribers: Subscriber<T>[] = [];
    private observable: Observable<T> = new Observable<T>(x=>{
        this.subscribers.push(x);
        return (_)=>{this.subscribers.splice(this.subscribers.indexOf(_), 1)};
    });

    next(value : T) {
        for (const subscriber of this.subscribers) {
            subscriber.next(value);
        }
    }

    subscribe(next?: (value: T) => void, error?: (error: any) => void, complete?: () => void): Subscription {
        return this.observable.subscribe(next, error, complete);
    }

}
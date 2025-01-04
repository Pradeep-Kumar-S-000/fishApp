import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PostListComponent } from "./components/post-list/post-list.component";
import { ItemComponent } from './components/item/item.component';

@Component({
  selector: 'fishApp-root',
  imports: [RouterOutlet, PostListComponent, ItemComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
}

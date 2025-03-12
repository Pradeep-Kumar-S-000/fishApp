import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PostListComponent } from "./components/post-list/post-list.component";
import { ItemComponent } from './components/item/item.component';

@Component({
  selector: 'fishApp-root',
  imports: [ItemComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  scrollToContent(): void {
    const contentElement = document.getElementById('content');
    if (contentElement) {
      contentElement.scrollIntoView({ behavior: 'smooth' }); // Smooth scroll to the content div
    }
  }
}

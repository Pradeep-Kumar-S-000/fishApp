import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ConfigService } from '../../services/config-service';

@Component({
  selector: 'fishApp-post-list',
  imports: [CommonModule],
  templateUrl: './post-list.component.html',
  styleUrl: './post-list.component.scss'
})
export class PostListComponent {
  private configService = inject(ConfigService);

  posts$ = this.configService.getPosts();
}

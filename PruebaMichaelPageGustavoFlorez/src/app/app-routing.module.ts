import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  { path: 'home', loadChildren: './home/home.module#HomePageModule' },
  { path: 'view-list', loadChildren: './view-list/view-list.module#ViewListPageModule' },
  { path: 'create-item', loadChildren: './create-item/create-item.module#CreateItemPageModule' },
  { path: 'edit-item', loadChildren: './edit-item/edit-item.module#EditItemPageModule' },
  { path: 'delete-item', loadChildren: './delete-item/delete-item.module#DeleteItemPageModule' },
  { path: 'view-todos', loadChildren: './view-todos/view-todos.module#ViewTodosPageModule' }
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

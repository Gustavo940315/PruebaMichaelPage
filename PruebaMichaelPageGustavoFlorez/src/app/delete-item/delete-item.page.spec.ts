import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteItemPage } from './delete-item.page';

describe('DeleteItemPage', () => {
  let component: DeleteItemPage;
  let fixture: ComponentFixture<DeleteItemPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteItemPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteItemPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

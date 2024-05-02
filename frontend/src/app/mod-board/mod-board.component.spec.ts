import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModBoardComponent } from './mod-board.component';

describe('ModBoardComponent', () => {
  let component: ModBoardComponent;
  let fixture: ComponentFixture<ModBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

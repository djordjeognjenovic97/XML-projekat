import { TestBed } from '@angular/core/testing';

import { TemplejtService } from './templejt.service';

describe('TemplejtService', () => {
  let service: TemplejtService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TemplejtService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

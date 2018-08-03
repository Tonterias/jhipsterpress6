import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import {
    CalbumComponent,
    CalbumDetailComponent,
    CalbumUpdateComponent,
    CalbumDeletePopupComponent,
    CalbumDeleteDialogComponent,
    calbumRoute,
    calbumPopupRoute
} from './';

const ENTITY_STATES = [...calbumRoute, ...calbumPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [CalbumComponent, CalbumDetailComponent, CalbumUpdateComponent, CalbumDeleteDialogComponent, CalbumDeletePopupComponent],
    entryComponents: [CalbumComponent, CalbumUpdateComponent, CalbumDeleteDialogComponent, CalbumDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06CalbumModule {}

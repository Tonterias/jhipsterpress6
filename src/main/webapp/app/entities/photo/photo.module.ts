import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import {
    PhotoComponent,
    PhotoDetailComponent,
    PhotoUpdateComponent,
    PhotoDeletePopupComponent,
    PhotoDeleteDialogComponent,
    photoRoute,
    photoPopupRoute
} from './';

const ENTITY_STATES = [...photoRoute, ...photoPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [PhotoComponent, PhotoDetailComponent, PhotoUpdateComponent, PhotoDeleteDialogComponent, PhotoDeletePopupComponent],
    entryComponents: [PhotoComponent, PhotoUpdateComponent, PhotoDeleteDialogComponent, PhotoDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06PhotoModule {}

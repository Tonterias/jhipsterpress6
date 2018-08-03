import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import { JhipsterPress06AdminModule } from 'app/admin/admin.module';
import {
    AlbumComponent,
    AlbumDetailComponent,
    AlbumUpdateComponent,
    AlbumDeletePopupComponent,
    AlbumDeleteDialogComponent,
    albumRoute,
    albumPopupRoute
} from './';

const ENTITY_STATES = [...albumRoute, ...albumPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, JhipsterPress06AdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [AlbumComponent, AlbumDetailComponent, AlbumUpdateComponent, AlbumDeleteDialogComponent, AlbumDeletePopupComponent],
    entryComponents: [AlbumComponent, AlbumUpdateComponent, AlbumDeleteDialogComponent, AlbumDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06AlbumModule {}

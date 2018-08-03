import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import {
    BlockeduserComponent,
    BlockeduserDetailComponent,
    BlockeduserUpdateComponent,
    BlockeduserDeletePopupComponent,
    BlockeduserDeleteDialogComponent,
    blockeduserRoute,
    blockeduserPopupRoute
} from './';

const ENTITY_STATES = [...blockeduserRoute, ...blockeduserPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BlockeduserComponent,
        BlockeduserDetailComponent,
        BlockeduserUpdateComponent,
        BlockeduserDeleteDialogComponent,
        BlockeduserDeletePopupComponent
    ],
    entryComponents: [BlockeduserComponent, BlockeduserUpdateComponent, BlockeduserDeleteDialogComponent, BlockeduserDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06BlockeduserModule {}

import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import {
    ActivityComponent,
    ActivityDetailComponent,
    ActivityUpdateComponent,
    ActivityDeletePopupComponent,
    ActivityDeleteDialogComponent,
    activityRoute,
    activityPopupRoute
} from './';

const ENTITY_STATES = [...activityRoute, ...activityPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        ActivityComponent,
        ActivityDetailComponent,
        ActivityUpdateComponent,
        ActivityDeleteDialogComponent,
        ActivityDeletePopupComponent
    ],
    entryComponents: [ActivityComponent, ActivityUpdateComponent, ActivityDeleteDialogComponent, ActivityDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06ActivityModule {}

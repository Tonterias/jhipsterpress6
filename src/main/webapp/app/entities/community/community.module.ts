import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPress06SharedModule } from 'app/shared';
import { JhipsterPress06AdminModule } from 'app/admin/admin.module';
import {
    CommunityComponent,
    CommunityDetailComponent,
    CommunityUpdateComponent,
    CommunityDeletePopupComponent,
    CommunityDeleteDialogComponent,
    communityRoute,
    communityPopupRoute
} from './';

const ENTITY_STATES = [...communityRoute, ...communityPopupRoute];

@NgModule({
    imports: [JhipsterPress06SharedModule, JhipsterPress06AdminModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        CommunityComponent,
        CommunityDetailComponent,
        CommunityUpdateComponent,
        CommunityDeleteDialogComponent,
        CommunityDeletePopupComponent
    ],
    entryComponents: [CommunityComponent, CommunityUpdateComponent, CommunityDeleteDialogComponent, CommunityDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06CommunityModule {}

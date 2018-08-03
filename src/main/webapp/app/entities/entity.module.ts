import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { JhipsterPress06BlogModule } from './blog/blog.module';
import { JhipsterPress06PostModule } from './post/post.module';
import { JhipsterPress06TopicModule } from './topic/topic.module';
import { JhipsterPress06TagModule } from './tag/tag.module';
import { JhipsterPress06CommentModule } from './comment/comment.module';
import { JhipsterPress06MessageModule } from './message/message.module';
import { JhipsterPress06NotificationModule } from './notification/notification.module';
import { JhipsterPress06ProfileModule } from './profile/profile.module';
import { JhipsterPress06CommunityModule } from './community/community.module';
import { JhipsterPress06FollowModule } from './follow/follow.module';
import { JhipsterPress06BlockeduserModule } from './blockeduser/blockeduser.module';
import { JhipsterPress06AlbumModule } from './album/album.module';
import { JhipsterPress06CalbumModule } from './calbum/calbum.module';
import { JhipsterPress06PhotoModule } from './photo/photo.module';
import { JhipsterPress06InterestModule } from './interest/interest.module';
import { JhipsterPress06ActivityModule } from './activity/activity.module';
import { JhipsterPress06CelebModule } from './celeb/celeb.module';
import { JhipsterPress06UrllinkModule } from './urllink/urllink.module';
import { JhipsterPress06FrontpageconfigModule } from './frontpageconfig/frontpageconfig.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        JhipsterPress06BlogModule,
        JhipsterPress06PostModule,
        JhipsterPress06TopicModule,
        JhipsterPress06TagModule,
        JhipsterPress06CommentModule,
        JhipsterPress06MessageModule,
        JhipsterPress06NotificationModule,
        JhipsterPress06ProfileModule,
        JhipsterPress06CommunityModule,
        JhipsterPress06FollowModule,
        JhipsterPress06BlockeduserModule,
        JhipsterPress06AlbumModule,
        JhipsterPress06CalbumModule,
        JhipsterPress06PhotoModule,
        JhipsterPress06InterestModule,
        JhipsterPress06ActivityModule,
        JhipsterPress06CelebModule,
        JhipsterPress06UrllinkModule,
        JhipsterPress06FrontpageconfigModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPress06EntityModule {}

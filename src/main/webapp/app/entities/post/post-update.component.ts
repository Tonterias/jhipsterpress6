import { Component, OnInit, ElementRef } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { IPost } from 'app/shared/model/post.model';
import { PostService } from './post.service';
import { IUrllink } from 'app/shared/model/urllink.model';
import { UrllinkService } from 'app/entities/urllink';
import { IBlog } from 'app/shared/model/blog.model';
import { BlogService } from 'app/entities/blog';
import { IProfile } from 'app/shared/model/profile.model';
import { ProfileService } from 'app/entities/profile';
import { ITag } from 'app/shared/model/tag.model';
import { TagService } from 'app/entities/tag';
import { ITopic } from 'app/shared/model/topic.model';
import { TopicService } from 'app/entities/topic';

@Component({
    selector: 'jhi-post-update',
    templateUrl: './post-update.component.html'
})
export class PostUpdateComponent implements OnInit {
    private _post: IPost;
    isSaving: boolean;

    urllinks: IUrllink[];

    blogs: IBlog[];

    profiles: IProfile[];

    tags: ITag[];

    topics: ITopic[];
    creationDate: string;
    publicationDate: string;

    constructor(
        private dataUtils: JhiDataUtils,
        private jhiAlertService: JhiAlertService,
        private postService: PostService,
        private urllinkService: UrllinkService,
        private blogService: BlogService,
        private profileService: ProfileService,
        private tagService: TagService,
        private topicService: TopicService,
        private elementRef: ElementRef,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ post }) => {
            this.post = post;
        });
        this.urllinkService.query({ filter: 'post(id)-is-null' }).subscribe(
            (res: HttpResponse<IUrllink[]>) => {
                if (!this.post.urllinkId) {
                    this.urllinks = res.body;
                } else {
                    this.urllinkService.find(this.post.urllinkId).subscribe(
                        (subRes: HttpResponse<IUrllink>) => {
                            this.urllinks = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.blogService.query().subscribe(
            (res: HttpResponse<IBlog[]>) => {
                this.blogs = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.profileService.query().subscribe(
            (res: HttpResponse<IProfile[]>) => {
                this.profiles = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.tagService.query().subscribe(
            (res: HttpResponse<ITag[]>) => {
                this.tags = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.topicService.query().subscribe(
            (res: HttpResponse<ITopic[]>) => {
                this.topics = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }

    setFileData(event, entity, field, isImage) {
        this.dataUtils.setFileData(event, entity, field, isImage);
    }

    clearInputImage(field: string, fieldContentType: string, idInput: string) {
        this.dataUtils.clearInputImage(this.post, this.elementRef, field, fieldContentType, idInput);
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.post.creationDate = moment(this.creationDate, DATE_TIME_FORMAT);
        this.post.publicationDate = moment(this.publicationDate, DATE_TIME_FORMAT);
        if (this.post.id !== undefined) {
            this.subscribeToSaveResponse(this.postService.update(this.post));
        } else {
            this.subscribeToSaveResponse(this.postService.create(this.post));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IPost>>) {
        result.subscribe((res: HttpResponse<IPost>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackUrllinkById(index: number, item: IUrllink) {
        return item.id;
    }

    trackBlogById(index: number, item: IBlog) {
        return item.id;
    }

    trackProfileById(index: number, item: IProfile) {
        return item.id;
    }

    trackTagById(index: number, item: ITag) {
        return item.id;
    }

    trackTopicById(index: number, item: ITopic) {
        return item.id;
    }

    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }
    get post() {
        return this._post;
    }

    set post(post: IPost) {
        this._post = post;
        this.creationDate = moment(post.creationDate).format(DATE_TIME_FORMAT);
        this.publicationDate = moment(post.publicationDate).format(DATE_TIME_FORMAT);
    }
}

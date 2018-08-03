import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IUrllink } from 'app/shared/model/urllink.model';
import { UrllinkService } from './urllink.service';
import { IPost } from 'app/shared/model/post.model';
import { PostService } from 'app/entities/post';

@Component({
    selector: 'jhi-urllink-update',
    templateUrl: './urllink-update.component.html'
})
export class UrllinkUpdateComponent implements OnInit {
    private _urllink: IUrllink;
    isSaving: boolean;

    posts: IPost[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private urllinkService: UrllinkService,
        private postService: PostService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ urllink }) => {
            this.urllink = urllink;
        });
        this.postService.query().subscribe(
            (res: HttpResponse<IPost[]>) => {
                this.posts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.urllink.id !== undefined) {
            this.subscribeToSaveResponse(this.urllinkService.update(this.urllink));
        } else {
            this.subscribeToSaveResponse(this.urllinkService.create(this.urllink));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IUrllink>>) {
        result.subscribe((res: HttpResponse<IUrllink>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackPostById(index: number, item: IPost) {
        return item.id;
    }
    get urllink() {
        return this._urllink;
    }

    set urllink(urllink: IUrllink) {
        this._urllink = urllink;
    }
}

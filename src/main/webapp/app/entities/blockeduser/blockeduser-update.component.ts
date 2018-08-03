import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IBlockeduser } from 'app/shared/model/blockeduser.model';
import { BlockeduserService } from './blockeduser.service';
import { ICommunity } from 'app/shared/model/community.model';
import { CommunityService } from 'app/entities/community';

@Component({
    selector: 'jhi-blockeduser-update',
    templateUrl: './blockeduser-update.component.html'
})
export class BlockeduserUpdateComponent implements OnInit {
    private _blockeduser: IBlockeduser;
    isSaving: boolean;

    communities: ICommunity[];
    creationDate: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private blockeduserService: BlockeduserService,
        private communityService: CommunityService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ blockeduser }) => {
            this.blockeduser = blockeduser;
        });
        this.communityService.query().subscribe(
            (res: HttpResponse<ICommunity[]>) => {
                this.communities = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.blockeduser.creationDate = moment(this.creationDate, DATE_TIME_FORMAT);
        if (this.blockeduser.id !== undefined) {
            this.subscribeToSaveResponse(this.blockeduserService.update(this.blockeduser));
        } else {
            this.subscribeToSaveResponse(this.blockeduserService.create(this.blockeduser));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBlockeduser>>) {
        result.subscribe((res: HttpResponse<IBlockeduser>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackCommunityById(index: number, item: ICommunity) {
        return item.id;
    }
    get blockeduser() {
        return this._blockeduser;
    }

    set blockeduser(blockeduser: IBlockeduser) {
        this._blockeduser = blockeduser;
        this.creationDate = moment(blockeduser.creationDate).format(DATE_TIME_FORMAT);
    }
}

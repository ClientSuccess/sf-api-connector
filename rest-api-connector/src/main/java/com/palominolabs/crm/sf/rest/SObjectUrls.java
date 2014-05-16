/*
 * Copyright © 2013. Palomino Labs (http://palominolabs.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palominolabs.crm.sf.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class SObjectUrls extends AbstractSObjectUrls {

    private final String uiEditTemplate;

    private final String uiDetailTemplate;
    private final String uiNewRecord;
    private final String passwordUtilities;
    @Nullable
    private final String caseArticleSuggestions;
    @Nullable
    private final String caseRowArticleSuggestions;

    @JsonCreator
    SObjectUrls(
            @Nonnull @JsonProperty("uiEditTemplate") String uiEditTemplate,
            @Nonnull @JsonProperty("sobject") String sobjectUrlPath,
            @Nonnull @JsonProperty("approvalLayouts") String approvalLayouts,
            @Nonnull @JsonProperty("quickActions") String quickActions,
            @Nonnull @JsonProperty("uiDetailTemplate") String uiDetailTemplate,
            @Nonnull @JsonProperty("describe") String describeUrlPath,
            @Nonnull @JsonProperty("rowTemplate") String rowTemplateUrlPath,
            @Nonnull @JsonProperty("layouts") String layoutsPath,
            @Nonnull @JsonProperty("compactLayouts") String compactLayouts,
            @Nonnull @JsonProperty("uiNewRecord") String uiNewRecord,
            @Nullable @JsonProperty("passwordUtilities") String passwordUtilities,
            @Nullable @JsonProperty("caseArticleSuggestions") String caseArticleSuggestions,
            @Nullable @JsonProperty("caseRowArticleSuggestions") String caseRowArticleSuggestions) {
        super(describeUrlPath, rowTemplateUrlPath, sobjectUrlPath, layoutsPath, approvalLayouts, quickActions, compactLayouts);
        this.uiEditTemplate = uiEditTemplate;
        this.uiDetailTemplate = uiDetailTemplate;
        this.uiNewRecord = uiNewRecord;
        this.passwordUtilities = passwordUtilities;
        this.caseArticleSuggestions = caseArticleSuggestions;
        this.caseRowArticleSuggestions = caseRowArticleSuggestions;
    }

    @Nonnull
    public String getUiEditTemplate() {
        return uiEditTemplate;
    }

    @Nonnull
    public String getUiDetailTemplate() {
        return uiDetailTemplate;
    }

    @Nonnull
    public String getUiNewRecord() {
        return uiNewRecord;
    }

    @Nullable
    public String getPasswordUtilities() {
        return passwordUtilities;
    }

    @Nullable
    public String getCaseArticleSuggestions() {
        return caseArticleSuggestions;
    }
}

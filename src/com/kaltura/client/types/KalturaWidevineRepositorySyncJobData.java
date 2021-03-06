// ===================================================================================================
//                           _  __     _ _
//                          | |/ /__ _| | |_ _  _ _ _ __ _
//                          | ' </ _` | |  _| || | '_/ _` |
//                          |_|\_\__,_|_|\__|\_,_|_| \__,_|
//
// This file is part of the Kaltura Collaborative Media Suite which allows users
// to do with audio, video, and animation what Wiki platfroms allow them to do with
// text.
//
// Copyright (C) 2006-2011  Kaltura Inc.
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
// @ignore
// ===================================================================================================
package com.kaltura.client.types;

import org.w3c.dom.Element;
import com.kaltura.client.KalturaParams;
import com.kaltura.client.KalturaApiException;
import com.kaltura.client.enums.KalturaWidevineRepositorySyncMode;
import com.kaltura.client.utils.ParseUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * This class was generated using generate.php
 * against an XML schema provided by Kaltura.
 * @date Thu, 16 Jan 14 11:44:35 -0500
 * 
 * MANUAL CHANGES TO THIS CLASS WILL BE OVERWRITTEN.
 */

public class KalturaWidevineRepositorySyncJobData extends KalturaJobData {
    public KalturaWidevineRepositorySyncMode syncMode;
    public String wvAssetIds;
    public String modifiedAttributes;
    public int monitorSyncCompletion = Integer.MIN_VALUE;

    public KalturaWidevineRepositorySyncJobData() {
    }

    public KalturaWidevineRepositorySyncJobData(Element node) throws KalturaApiException {
        super(node);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node aNode = childNodes.item(i);
            String nodeName = aNode.getNodeName();
            String txt = aNode.getTextContent();
            if (nodeName.equals("syncMode")) {
                this.syncMode = KalturaWidevineRepositorySyncMode.get(ParseUtils.parseInt(txt));
                continue;
            } else if (nodeName.equals("wvAssetIds")) {
                this.wvAssetIds = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("modifiedAttributes")) {
                this.modifiedAttributes = ParseUtils.parseString(txt);
                continue;
            } else if (nodeName.equals("monitorSyncCompletion")) {
                this.monitorSyncCompletion = ParseUtils.parseInt(txt);
                continue;
            } 
        }
    }

    public KalturaParams toParams() {
        KalturaParams kparams = super.toParams();
        kparams.add("objectType", "KalturaWidevineRepositorySyncJobData");
        kparams.add("syncMode", this.syncMode);
        kparams.add("wvAssetIds", this.wvAssetIds);
        kparams.add("modifiedAttributes", this.modifiedAttributes);
        kparams.add("monitorSyncCompletion", this.monitorSyncCompletion);
        return kparams;
    }

}


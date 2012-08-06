/*
 * Copyright © 2010. Team Lazer Beez (http://teamlazerbeez.com)
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

package com.teamlazerbeez.crm.sf.soap;

import com.teamlazerbeez.crm.sf.soap.jaxwsstub.partner.ErrorType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"ProhibitedExceptionCaught"})
public class PartnerApiErrorImplTest {

    @Test
    public void testMessageCantBeNull() {
        ErrorType stubError = new ErrorType();

        try {
            new PartnerApiErrorImpl(stubError);
        } catch (NullPointerException e) {
            assertEquals("message cannot be null", e.getMessage());
        }
    }

    @Test
    public void testStatusCodeCantBeNull() {
        ErrorType stubError = new ErrorType();
        stubError.setMessage("msg");

        try {
            new PartnerApiErrorImpl(stubError);
        } catch (NullPointerException e) {
            assertEquals("status code cannot be null", e.getMessage());
        }
    }
}

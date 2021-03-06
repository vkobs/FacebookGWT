/*
 * Copyright (C) 2010 deNormans
 * http://www.denormans.com/
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of deNormans ("Confidential Information"). You 
 * shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with deNormans.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * DENORMANS OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.denormans.facebookgwt.api.client.graph;

import com.denormans.facebookgwt.api.client.FBIntegration;
import com.denormans.facebookgwt.api.client.graph.actions.ApplicationGraph;
import com.denormans.facebookgwt.api.client.graph.actions.CommentGraph;
import com.denormans.facebookgwt.api.client.graph.actions.FBItemGraph;
import com.denormans.facebookgwt.api.client.graph.actions.FriendListGraph;
import com.denormans.facebookgwt.api.client.graph.actions.PhotoAlbumGraph;
import com.denormans.facebookgwt.api.client.graph.actions.PhotoGraph;
import com.denormans.facebookgwt.api.client.graph.actions.PostableGraph;
import com.denormans.facebookgwt.api.client.graph.actions.UserGraph;
import com.denormans.facebookgwt.api.client.graph.actions.VideoGraph;
import com.denormans.facebookgwt.api.client.graph.options.FBGraphCallOptions;
import com.denormans.facebookgwt.api.client.graph.model.FBGraphObject;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class FBGraph extends FBIntegration {
  public final ApplicationGraph Application = new ApplicationGraph();
  public final CommentGraph Comment = new CommentGraph();
  public final FriendListGraph FriendList = new FriendListGraph();
  public final PhotoGraph Photo = new PhotoGraph();
  public final PhotoAlbumGraph PhotoAlbum = new PhotoAlbumGraph();
  public final PostableGraph Postable = new PostableGraph();
  public final UserGraph User = new UserGraph();
  public final VideoGraph Video = new VideoGraph();

  private final GenericItemGraph genericItemGraph = new GenericItemGraph();

  /**
   * Like an item (e.g. post, comment, etc.)
   *
   * @param itemID The item ID
   * @param callback Called when complete
   */
  public void likeItem(final String itemID, final AsyncCallback<Boolean> callback) {
    genericItemGraph.like(itemID, callback);
  }

  /**
   * Unlike an item (e.g. post, comment, etc.)
   *
   * @param itemID The item ID
   * @param callback Called when complete
   */
  public void unlikeItem(final String itemID, final AsyncCallback<Boolean> callback) {
    genericItemGraph.unlike(itemID, callback);
  }

  // Generic graph methods
  /**
   * Retrieves an item by ID.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called with the result
   */
  @SuppressWarnings({"unchecked"})
  public void retrieveItem(final String itemID, final FBGraphCallOptions options, final AsyncCallback<? extends FBGraphObject> callback) {
    genericItemGraph.retrieveByID(itemID, options, (AsyncCallback<FBGraphObject>)callback);
  }

  /**
   * Deletes the item.
   *
   * @param itemID The item ID
   * @param options The call options
   * @param callback Called when complete
   */
  public void deleteItem(final String itemID, final FBGraphCallOptions options, final AsyncCallback<Boolean> callback) {
    genericItemGraph.delete(itemID, options, callback);
  }

  private static class GenericItemGraph extends FBItemGraph<FBGraphObject> {
    @Override
    protected void like(final String itemID, final AsyncCallback<Boolean> callback) {
      super.like(itemID, callback);
    }

    @Override
    protected void unlike(final String itemID, final AsyncCallback<Boolean> callback) {
      super.unlike(itemID, callback);
    }
  }
}

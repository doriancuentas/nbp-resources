/**
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

#include "../rfs_filedata.h"
#include "../rfs_protocol.h"
#include "../rfs_util.h"
#include "../rfs_controller.h"
#include "../rfs_preload_socks.h"

int main(int argc, char** argv) {
    trace_startup("PKG_TEST", 0);
    int sd = get_socket(true);
    if (sd <= 0) {
        perror("error getting socket");
        return 1;
    }
    const char* path = "mypath";
    trace("Sending \"%s\" to sd=%d\n", path, sd);
    enum sr_result send_res = pkg_send(sd, pkg_request, path);
    if (send_res == sr_failure) {
        perror("send");
    } else if (send_res == sr_reset) {
        perror("Connection reset by peer when sending request");
    } else { // success
        trace("Request for \"%s\" sent to sd=%d\n", path, sd);
        const int maxsize = 256;
        char buffer[maxsize + sizeof(int)];
        struct package *pkg = (struct package *) &buffer;
        enum sr_result recv_res = pkg_recv(sd, pkg, maxsize);
        if (recv_res == sr_failure) {
            perror("Error receiving response");
        } else if (recv_res == sr_reset) {
            perror("Connection reset by peer when receiving response");
        } else { // success
            if (pkg->kind == pkg_reply) {
                trace("Got %s for %s, sd=%d\n", pkg->data, path, sd);
                if (pkg->data[0] == response_ok) {
                    trace("OK\n");
                } else if (pkg->data[0] == response_failure) {
                    trace("FAILURE\n");
                } else {
                    trace("Protocol error, sd=%d\n", sd);
                }
            } else {
                trace("Protocol error: get pkg_kind %d instead of %d\n", pkg->kind, pkg_reply);
            }
        }
    }
    return 0;
}

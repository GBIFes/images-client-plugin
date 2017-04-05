package images.client.plugin

/**
 * Image Client Tag Lib to be used in the gsp related to image client plugin feature
 *
 */
class ImageClientTagLib {

    def authService
    static namespace = 'imageClient'

    /**
     *
     *  Outputs true if user is logged in and user role is in the allowable configured roles: allowedImageEditingRoles (Note that the IP must also match the authorised system IP for the user).
     *  Otherwise, outputs false.
     *
     */
    def checkAllowableEditRole = { attrs ->
        List<String> allowedRoles = grailsApplication.config.get("allowedImageEditingRoles")?.split(",")?:[]
        def currentUserRoles = authService?.getUserId() ? authService.getUserForUserId(authService.getUserId())?.roles : []
        boolean match = currentUserRoles.any {allowedRoles.contains(it)}
        out << match;
    }

}
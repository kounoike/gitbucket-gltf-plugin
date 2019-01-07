import gitbucket.core.plugin.{RenderRequest, Renderer}
import play.twirl.api.Html
import gitbucket.core.view.helpers.urlEncode

class GltfRenderer extends Renderer {
  def render(req: RenderRequest): Html = {
    val url = s"${req.context.path}/${req.repository.owner}/${req.repository.name}/raw/${req.branch}/" +
        req.filePath.mkString("/")
    Html(
      s"""<script src="${req.context.path}/plugin-assets/gltf/js/model-viewer.js"></script>
        |<model-viewer src="${url}" controls auto-rotate></model-viewer>""".stripMargin)
  }
}
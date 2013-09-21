<ui:composition xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:rich="http://richfaces.org/rich">
    <p>Here is an example of tab panel switched in "ajax" style. Second tab is disabled.</p>
    <rich:tabPanel switchType="ajax">
        <rich:tab label="Login Info">
            Here is tab #1
        </rich:tab>
        <rich:tab label="Billing Address" disabled="true">
            Here is tab #2
        </rich:tab>
        <rich:tab label="Shipping Address">
            Here is tab #3
        </rich:tab>
    </rich:tabPanel>
    <br/><br/>
</ui:composition>
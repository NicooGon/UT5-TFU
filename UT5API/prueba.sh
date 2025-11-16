#!/bin/bash

# URL del servicio SOAP (incluye el context-path /UT5API)
SOAP_URL="http://localhost:8080/UT5API/ws"

# Namespace generado por tus clases JAXB/WSDL
NAMESPACE="http://artistapi.com/users"

# ID del usuario a consultar
USER_ID=1

# XML del request SOAP
read -r -d '' SOAP_REQUEST << EOM
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:usr="$NAMESPACE">
   <soapenv:Header/>
   <soapenv:Body>
      <usr:getUserByIdRequest>
         <usr:userId>$USER_ID</usr:userId>
      </usr:getUserByIdRequest>
   </soapenv:Body>
</soapenv:Envelope>
EOM

# Ejecutar la request con curl
curl -s -X POST \
     -H "Content-Type: text/xml;charset=UTF-8" \
     -H "SOAPAction: \"$NAMESPACE/getUserByIdRequest\"" \
     -d "$SOAP_REQUEST" \
     "$SOAP_URL"

module.exports =[
    {
        context: ['/api/**','/api/v1/*'], //match these requests
        target:'http://localhost:8080', //Spingboot
        secure: false
    }
]
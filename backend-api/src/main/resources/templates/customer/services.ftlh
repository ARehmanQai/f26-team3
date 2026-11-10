<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-ec-light-blue">
        <div class="container-fluid d-flex">
            <a class="navbar-brand link-light fw-bold" href="../home.html">
                <img src="../resources/logo.png" alt="Event Crew Logo" width="75" height="34">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto ">



                    <li class="nav-item">
                        <a class="nav-link nav-button" aria-current="page" href="#"> Browse Provider</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-button" href="../provider/signup.html">Become a provider</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-button" href="#">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link signup-button" href="signup.html">Sign Up</a>
                    </li>

    
                    </form>
                    </li>


                </ul>
            </div>
        </div>
    </nav>

<div class="container mt-4"> 
    <h1>Browse Available Services</h1> 
    <p>Welcome, ${customer.name}! Explore the services available for your event.</p>

    <div class="row mt-4"> 
        <#if services?has_content> <#list services as service> 
        <div class="col-md-6 col-lg-4 mb-4"> <div class="card h-100"> 
            <div class="card-body"> 
                <h5 class="card-title">${service.name}</h5> 
                <p class="card-text">${service.description}</p> 
                <p><strong>Category:</strong> ${service.category}</p> 
                <p><strong>Price:</strong> $${service.price}</p> 
                <p><strong>Duration:</strong> ${service.duration} minutes</p> 
            </div> 
        </div> 
    </div> 
    </#list>

    <#else> 
    <div class="col-12"> 
        <p>No available services were found.</p> 
    </div> 
    </#if> 
</div> 
<a href="/customer/dashboard/${customer.id}" class="btn event-button"> Back to Dashboard </a> 
</div>







</body>
</html>
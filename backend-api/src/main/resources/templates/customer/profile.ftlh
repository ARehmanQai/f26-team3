<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Profile</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/styles.css">
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


    <div class="container mt-5 profile-header">
    <h1 class="text-center">Manage Your Profile</h1>
    <p class="text-center"> Update your account information. </p>
    </div>



    <#if successMessage??>
    <div class="alert alert-success text-center" role="alert">
        ${successMessage}
    </div>
    </#if>
    <div class="container mt-4">
<form class="profile-container" method="post" action="/customer/profile/${customer.id}">

    <div class="mb-3">
        <label for="fullName" class="form-label">Change Your Full Name</label>
        <input
            type="text"
            class="form-control"
            id="fullName"
            name="name"
            value="${customer.name}"
            required>
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Change Your Email Address</label>
        <input
            type="email"
            class="form-control"
            id="email"
            name="email"
            value="${customer.email}"
            required>
    </div>

    <div class="mb-3">
        <label for="phoneNumber" class="form-label">Change Your Phone Number</label>
        <input
            type="tel"
            class="form-control"
            id="phoneNumber"
            name="phoneNumber"
            value="${customer.phoneNumber}"
            required>
    </div>

    <div class="mb-3">
        <label for="newPassword" class="form-label">Change Your Password</label>
        <input
            type="password"
            class="form-control"
            id="newPassword"
            name="password"
            placeholder="Leave blank to keep your current password">
    </div>

    <button type="submit" class="btn event-button">Save Changes</button>

</form>

    
</body>


</html>